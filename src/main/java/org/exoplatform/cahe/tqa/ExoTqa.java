package org.exoplatform.cahe.tqa;

/**
 * Created by IntelliJ IDEA.
 * User: Tleti
 * Date: 26/11/12
 * Time: 17:42
 * To change this template use File | Settings | File Templates.
 */
public class ExoTqa {

    String name;
    String path;

    public ExoTqa(String a, String b) {
        this.name = a;
        this.path = b;

    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return " name = " + this.getName() + "  and path = " + this.getPath();
    }

}
