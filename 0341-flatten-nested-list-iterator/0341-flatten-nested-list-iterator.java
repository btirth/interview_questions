
public class NestedIterator implements Iterator<Integer> {

    List<Integer> flattenList;
    int curr;
    public NestedIterator(List<NestedInteger> nestedList) {
        flattenList = new ArrayList<>();
        curr = 0;
        
        for(NestedInteger nestedInt: nestedList) {
            helper(nestedInt);
        }
    }

    @Override
    public Integer next() {
        return flattenList.get(curr++);
    }

    @Override
    public boolean hasNext() {
        if(curr < flattenList.size()) {
            return true;
        }
        
        return false;
    }
    
    void helper(NestedInteger value) {
        if(value.isInteger()) {
            flattenList.add(value.getInteger());
        } else {
            for(NestedInteger nestedInt: value.getList()) {
                helper(nestedInt);
            }
        } 
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */