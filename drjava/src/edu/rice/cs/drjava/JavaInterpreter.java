package  edu.rice.cs.drjava;

/**
 * Interface for repl interpreters.
 * @version $Id$
 */
public interface JavaInterpreter {
  public static final Object NO_RESULT = new Object();

  /**
   * Interprets the given string.
   * @param s Java source to interpret
   * @return The result of the interpretation, or {@see #NO_RESULT} if
   *         the interpretation had no return value.
   */
  public Object interpret(String s);

  /**
   * Adds the given path to the interpreter's classpath.
   * @param path Path to add
   */
  public void addClassPath(String path);

  /**
   * Set the scope for unqualified names to the given package.
   * @param packageName Package to assume scope of.
   */
  public void setPackageScope(String packageName);
}



