package by.it.machuga.jd02_07.interfaces;

public interface Constants {
    String ALPHABET_UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String ALPHABET_LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    String USER_DIR = "user.dir";
    String SRC = "src";
    String NAME_PATTERN = "(?<=['])[a-zA-Z]+";
    String AGE_PATTERN = "[0-9]+";
    String IS_ACTIVE_PATTERN = "(true|false)";
    String FILE_EXTENSION = ".txt";
    String EMPTY_STRING = "";

    int POOL_SIZE = 4;
    int NUMBER_THREADS = 20;
    int TOP_SIZE = 5;
    int PLAYERS_COUNT = 10;
    int FILE_NAME_SIZE = 5;
    int PLAYER_NAME_SIZE = 5;
    int MIN_AGE = 20;
    int MAX_AGE = 40;
    int MIN_AGE_FILTER = 25;
    int MAX_AGE_FILTER = 30;
    boolean IS_ACTIVE_FILTER = true;
}
