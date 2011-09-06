package br.edu.ufcg.srh.adicionais.server;

import java.io.File;

/**
 * A data folder.
 * 
 * @author Cleber G. de Sousa
 */
public enum DataFolder {
    SERVIDORES;

    /**
     * @return the directory corresponding to the given path
     */
    private static File getOrMakeDirectory(String path) {
        File directory = new File(path);

        try {
            if (!directory.exists()) {
                directory.mkdir();
            }
        } catch (SecurityException e) {
            throw new RuntimeException(
                    "can't create the given directory: " + path);
        }

        return directory;
    }

    /**
     * @return the path of the root folder
     */
    private static String getRootPath() {
        return "adicionais_dados";
    }

    /**
     * @return the directory of the root folder
     */
    private static File getRootDirectory() {
        return DataFolder.getOrMakeDirectory(DataFolder.getRootPath());
    }

    /**
     * @return the path of this data folder
     */
    public String getPath() {
        return DataFolder.getRootPath() + System.getProperty("file.separator")
                + this.name().toLowerCase();
    }

    /**
     * @return the directory of this data folder
     */
    public File getDirectory() {
        DataFolder.getRootDirectory();
        return DataFolder.getOrMakeDirectory(this.getPath());
    }
}
