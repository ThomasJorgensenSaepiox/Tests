package tester;

import java.util.Optional;

public interface userVariables extends SessionVariables {
    public Optional<String> geteMail();
    public Optional<String> getPass();
    public Optional<String> getUserName();
}
