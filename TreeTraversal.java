import java.util.*;

public class TreeTraversal {
    public List<String> traverse(String root, Map<String, List<String>> tree) {
        List<String> res = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        int level = 1;
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<String> nodes = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                String node = q.poll();
                nodes.add(node);
                // get the value from the node key in the tree map
                List<String> children = tree.getOrDefault(node, new ArrayList<>());
                q.addAll(children);
            }
            if (level % 2 == 1) {
                Collections.reverse(nodes);
            }

            res.addAll(nodes); // adds every node in nodes into result
            level++;
        }
        return res;
    }

}
