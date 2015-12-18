package nl.ica.oose.project.juke.common.persistence;

import com.jcraft.jsch.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

/**
 * This class makes an sftp connection and allows subclasses of this class to place files on a file system using SSH FTP
 *
 * @author Harm Tacoma
 * @see nl.ica.oose.project.juke.common.persistence.ISftp
 */
public class Sftp implements ISftp {

    private Channel channel;
    private Session session;
    protected ChannelSftp channelsftp;
    private JSch jsch = new JSch();
    protected Logger logger;

    /**
     * The constructor used to create a Sftp.
     *
     * @param sftpconfig The configuration for Sftp.
     */
    public Sftp(ISftpConfig sftpconfig) {
        logger = LoggerFactory.getLogger(this.getClass());
        try {
            session = jsch.getSession(sftpconfig.getSftpuser(), sftpconfig.getSftphost(), sftpconfig.getSftpport());
            session.setPassword(sftpconfig.getSftppass());
            Properties config = new Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);
            session.connect();
            channel = session.openChannel("sftp");
            channel.connect();
            channelsftp = (ChannelSftp) channel;
            if (!sftpconfig.getHttpserverdir().isEmpty() || !sftpconfig.getWorkingdir().isEmpty()) {
                channelsftp.cd("" + sftpconfig.getHttpserverdir() + sftpconfig.getWorkingdir());
            }
        } catch (JSchException e) {
            logger.error("JSchException has been triggered in the constructor of sftp.java", e);
        } catch (SftpException e) {
            logger.error("SftpException has been triggered in the constructor of sftp.java", e);
        }
    }

    /**
     * {@inheritDoc}
     */
    public boolean isValid() {
        return session.isConnected() && channel.isConnected();
    }
}
