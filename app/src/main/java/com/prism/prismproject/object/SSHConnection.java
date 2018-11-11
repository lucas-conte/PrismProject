package com.prism.prismproject.object;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.prism.prismproject.constant.Constant;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class SSHConnection {
    private String host;
    private static final String user = "pi";
    private static final String password = "raspberry";
    private static final int port = 22;

    private JSch jSch;
    private Session session;
    private ChannelExec channel;

    private ByteArrayOutputStream Baos;
    private ByteArrayInputStream Bais;

    private String command;

    public SSHConnection(int idConsole, Context context){
        jSch = new JSch();
        Baos = new ByteArrayOutputStream();
        Bais = new ByteArrayInputStream(new byte[2000]);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        host = preferences.getString(Constant.IP_ADDRESS, "192.168.43.23");

        if (idConsole == Constant.PAGE_SUPERNINTENDO){
            command = "/opt/retropie/emulators/retroarch/bin/retroarch -L /opt/retropie/libretrocores/lr-snes9x2010/snes9x2010_libretro.so --config /opt/retropie/configs/snes/retroarch.cfg /home/pi/RetroPie/roms/snes/%s --appendconfig /dev/shn/retroarch.cfg";
        }else if (idConsole == Constant.PAGE_PS1){
            command = "/opt/retropie/emulators/retroarch/bin/retroarch -L /opt/retropie/libretrocores/lr-pcsx-rearmed/libretro.so --config /opt/retropie/configs/psx/retroarch.cfg /home/pi/RetroPie/roms/psx/%s --appendconfig /dev/shn/retroarch.cfg";
        }else if (idConsole == Constant.PAGE_NINTENDO_64){
            command = "/opt/retropie/emulators/mupen64plus/bin/mupen64plus.sh AUTO /home/pi/RetroPie/roms/n64/%s";
        }else if (idConsole == Constant.STOP){
            command = "killall -9 %s";
        }
    }

    public Session connect(){
        try {
            session = jSch.getSession(user, host, port);
            session.setPassword(password);
            session.setConfig("StrictHostKeyChecking", "No");
            session.connect();
        } catch (JSchException e) {
            e.printStackTrace();
        }
        return session;
    }

    public void disconnect(){
        channel.disconnect();
        session.disconnect();
    }

    public void playCommand(String game){
        try {
            channel = (ChannelExec) session.openChannel("exec");

            command = String.format(command, game);
            Log.d("COMMAND: ", command);
            channel.setCommand(command);

            channel.setInputStream(Bais);
            channel.setOutputStream(Baos);

            channel.connect();

            try{
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                disconnect();
            }
        } catch (JSchException e) {
            e.printStackTrace();
            Log.d("COMMAND ", "ERRO");
        }

        channel.disconnect();
    }

    public String getBaos(){
        return this.Baos.toString();
    }
}
