package delta.codecharacter.server.util;

import java.io.File;

public class MapUtil {

    private static String mapStoragePath = "storage/maps";

    /**
     * Return the absolute path to the map directory
     *
     * @return Path to codes directory
     */
    public static String getMapRepositoryUri() {
        return System.getProperty("user.dir") + File.separator + mapStoragePath;
    }

    /**
     * Return the absolute path to the map file for the given mapId
     *
     * @param mapId MapId of the map to be accessed
     * @return Path to map file
     */
    public static String getMapFileUri(Integer mapId) {
        return getMapRepositoryUri() + File.separator + mapId;
    }

    /**
     * Get map of given mapId
     *
     * @param mapId MapId of the map
     * @return Contents of the map file
     */
    public static String getMap(Integer mapId) {
        String mapFileUri = getMapFileUri(mapId);
        try {
            return FileHandler.getFileContents(mapFileUri);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
