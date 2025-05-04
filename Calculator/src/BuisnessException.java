/*

Отдельно созданные Business исключения, для работы нашей программы.

 */

public class BuisnessException {
}

class RykaLicoException extends Exception {
    RykaLicoException(String message) {
        super(message);
    }

}

class IlligalInputDataException extends Exception {
    IlligalInputDataException(String message) {
        super(message);
    }
}

class ChtoToNeTakException extends Exception {
    ChtoToNeTakException(String message) {
        super(message);
    }
}