import java.util.LinkedList;
import java.util.List;

public class Tree {

    public Object val;
    public String name;
    public Tree parent;
    public String type;
    public List<Object> children = new LinkedList<>();

    Tree(String n, Object data, String t){
        name = n;
        val = data;
        parent = null;
        type = t;
    }
    
    Tree(String n, Object data, Tree p, String t){
        name = n;
        val = data;
        parent = p;
        type = t;
        
        if (type.equals("file")) {
            if (parent.val != null)
                parent.setData((int)parent.val + (int)data);
            else parent.setData((int)data);
        }
    }

    public void add (Object o) {
        children.add(o);
    }

    public boolean hasParent() {
        return parent != null;
    }
    
    public boolean hasChildren() {
        return children.size() != 0;
    }
    
    public void setData(Object data) {
        int old = 0;
        if (val != null) {
            old = (int)val;
        }
        val = data;
        if(hasParent() && parent.val != null) {
            if (old != 0)
                parent.setData(((int)parent.val + (int)data) - (int)old);
            else if (parent.val != null)
                parent.setData((int)parent.val + (int)data);
            else if (parent.val == null)
                parent.setData((int)data);
        } 
    }
    
    
}
