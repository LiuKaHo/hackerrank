package datastruct.tree;


import java.util.*;

/**
 * @author liukaho
 * @date 2020/6/21 10:50 AM
 */

//not finish
public class KittysCalculationsonaTree {

    static class KittyNode{
        int data;
        Map<Integer, KittyNode> children;

        public KittyNode(int data){
            this.data = data;
            children = new HashMap<>();
        }
    }

    static double moduloNum = Math.pow(10, 9)+7;

    static int res = 0;

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);


        //read first line
        String firstLine = scanner.nextLine();
        String[] nAndq = firstLine.split(" ");
        int n = Integer.parseInt(nAndq[0])-1;
        int q = Integer.parseInt(nAndq[1]);

        KittyNode root = null;
        //generate tree
        for (;n>0; n--){
            String nodesLine = scanner.nextLine();
            String[] nodes = nodesLine.split(" ");
            int parent = Integer.parseInt(nodes[0]);
            int child = Integer.parseInt(nodes[1]);
            root = putChild(root, parent, child);
        }
        for (int i = 0; i < q; i++){
            int setNum = Integer.parseInt(scanner.nextLine());
            int[] set = new int[setNum];
            String setLine = scanner.nextLine();
            String[] sets = setLine.split(" ");
            for (int m = 0; m < setNum; m++){
                set[m] = Integer.parseInt(sets[m]);
            }

            System.out.println(calculations(root, set));
        }
    }

    public static int calculations(KittyNode root, int[] set) {
        if (set.length < 2){
            return 0;
        }

        if (set.length == 2){
            LCA(root, set[0], set[1]);
            return (int)((res*set[0]*set[1])%moduloNum);
        }

        int sum = 0;
        for (int i = 0;i < set.length-1; i++){
            for (int m = i+1; m < set.length; m++){
                LCA(root, set[i], set[m]);
                sum += res*set[i]*set[m];
            }
        }
        return (int)(sum%moduloNum);
    }

    public static int LCA(KittyNode root, int u, int v) {
        if (root == null){
            return 0;
        }

        int notZeroNum = 0;
        List<Integer> notZeroSet = new ArrayList<>();

        for (Map.Entry<Integer, KittyNode> node : root.children.entrySet()){
            int temp = LCA(node.getValue(), u, v);
            if (temp != 0){
                notZeroNum++;
                notZeroSet.add(temp);
            }
        }




        int sum = 0;
        for (int num : notZeroSet){
            sum+=num;
        }

        if (((notZeroNum == 2) || ((notZeroNum == 1) && (root.data==u || root.data == v)))){
            res = sum;
        }
        if ((root.data == u || root.data == v) || notZeroNum == 1){
            sum++;
        }

        return sum;

    }


    public static KittyNode putChild(KittyNode root, int parent, int child) {
        if (root == null){
            root = new KittyNode(parent);
            root.children.put(child, new KittyNode(child));
        } else {
            if (root.data == parent){
                root.children.put(child, new KittyNode(child));
            }
            for (Map.Entry<Integer, KittyNode> entry : root.children.entrySet()){
                root.children.put(entry.getKey(), putChild(entry.getValue(), parent, child));
            }
        }

        return root;

    }

}
