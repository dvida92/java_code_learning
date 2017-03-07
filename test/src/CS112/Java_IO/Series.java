package CS112.Java_IO;

/**
 *  You can specify one or more methods that have no body in an interface, but these methods must be implemented
 *  by a class in order for their actions to be defined. Thus, an interface specifies what must be done,
 *  but now how to do it.
 */
public interface Series {
    int getNext();
    void reset();
    void setStart(int x);


}
