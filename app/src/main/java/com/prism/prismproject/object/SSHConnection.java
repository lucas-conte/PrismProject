package com.prism.prismproject.object;

import android.util.Log;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public class SSHConnection {
    private static final String host = "192.168.43.23";
    private static final String user = "pi";
    private static final String password = "raspberry";
    private static final int port = 22;

    private JSch jSch;
    private Session session;
    private ChannelExec channel;

    private ByteArrayOutputStream Baos;
    private ByteArrayInputStream Bais;

//    private static final String commandPart1 = "/opt/retropie/supplementary/runcommand/runcommand1.sh 0 _SYS_";
    private static final String commandPart1 = "/opt/retropie/emulators/mupen64plus/bin/mupen64plus.sh AUTO ";
    private static final String commandPart2 = "/home/pi/RetroPie/roms/";

    private String nintendo64Command;
    private String superNintendoCommand;
    private String psCommand;

    public SSHConnection(){
        jSch = new JSch();
        Baos = new ByteArrayOutputStream();
        Bais = new ByteArrayInputStream(new byte[2000]);
        nintendo64Command = "/opt/retropie/emulators/mupen64plus/bin/mupen64plus.sh AUTO /home/pi/RetroPie/roms/n64/";
        superNintendoCommand = "/opt/retropie/emulators/retroarch/bin/retroarch -L /opt/retropie/libretrocores/lr-snes9x2010/snes9x2010_libretro.so --config /opt/retropie/configs/snes/retroarch.cfg /home/pi/RetroPie/roms/snes/supermario.smc --appendconfig /dev/shn/retroarch.cfg";
        psCommand = "/opt/retropie/emulators/retroarch/bin/retroarch -L /opt/retropie/libretrocores/lr-pcsx-rearmed/libretro.so --config /opt/retropie/configs/psx/retroarch.cfg /home/pi/RetroPie/roms/psx/ChronoCross1.cue --appendconfig /dev/shn/retroarch.cfg";
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

    public void playCommand(String emulator, String game){
        try {
            channel = (ChannelExec) session.openChannel("exec");

            String fullComand = commandPart1 + commandPart2 + emulator + "/" + game;
            Log.d("COMMAND: ", fullComand);
            channel.setCommand(psCommand);

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
