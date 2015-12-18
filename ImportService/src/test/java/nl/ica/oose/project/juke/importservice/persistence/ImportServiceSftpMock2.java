package nl.ica.oose.project.juke.importservice.persistence;

import com.jcraft.jsch.SftpException;

import java.io.FileInputStream;

public class ImportServiceSftpMock2 implements IImportServiceSftp {

    @Override
    public void writeFile(FileInputStream fis, String newname, int artistid, int albumid) throws SftpException {

    }

    @Override
    public String getWorkingDir() {
        return "/MusicSystem/Imports";
    }

    @Override
    public void setWorkingDir(String workingdir) {

    }

    @Override
    public String getTempDir() {
        return this.getClass().getClassLoader().getResource("").getFile() + "temp2/";
    }

    @Override
    public void setTempDir(String tempdir) {

    }

    @Override
    public boolean isValid() {
        return true;
    }
}
