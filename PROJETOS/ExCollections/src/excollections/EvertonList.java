package excollections;

import java.util.ArrayList;

public class EvertonList extends ArrayList {
    
    public void addNoInicio (Object o) {
        this.add(0,o);
    }

    @Override
    public boolean add(Object e) {
        this.addNoInicio(e);
        return true;
    }
    
    
}
