package vip.paolu.t17;

import java.io.*;
import java.util.*;

/**
 * Description:构建哈弗曼树编码
 * User: Pan
 * Date: 2023-03-26-22:04
 */
public class HuffmanCode {
    static Map<Byte, String> huffmanCodes = new HashMap<>();
    static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) {
        //String content = "i like like like java do you like a java";
        //byte[] contentBytes = content.getBytes();
        ////System.out.println(contentBytes.length);
        //byte[] huffmanBytes = huffmanZip(contentBytes);
        //System.out.println(Arrays.toString(huffmanBytes));
        //byte[] primaryCode = decode(huffmanCodes, huffmanBytes);
        //System.out.println(new String(primaryCode));

        //zipFile("C:\\Users\\f\\Desktop\\测试\\gb5.html", "C:\\Users\\f\\Desktop\\测试\\test.zip");
        unZipFile("C:\\Users\\f\\Desktop\\测试\\test.zip", "C:\\Users\\f\\Desktop\\测试\\resource.html");
    }

    public static void unZipFile(String zipFile, String dstFile) {
        InputStream is = null;
        //定义一个对象输入流
        ObjectInputStream ois = null;
        //定义文件的输出流
        OutputStream os = null;

        try {
            is = new FileInputStream(zipFile);
            ois = new ObjectInputStream(is);
            byte[] huffmanBytes = (byte[]) ois.readObject();
            Map<Byte, String> huffmanCodes = (Map<Byte, String>) ois.readObject();

            byte[] bytes = decode(huffmanCodes, huffmanBytes);
            os = new FileOutputStream(dstFile);
            os.write(bytes);

        } catch (Exception e) {
        } finally {
            try {
                os.close();
                ois.close();
                is.close();
            } catch (Exception e) {
                // TODO Auto-generated catch block
            }
        }

    }

    public static void zipFile(String srcFile, String dstFile) {
        OutputStream os = null;
        ObjectOutputStream oos = null;
        try {
            FileInputStream is = new FileInputStream(srcFile);
            byte[] b = new byte[is.available()];
            is.read(b);
            b = huffmanZip(b);
            os = new FileOutputStream(dstFile);
            oos = new ObjectOutputStream(os);
            ;
            oos.writeObject(b);
            oos.writeObject(huffmanCodes);
            System.out.println("压缩成功");
            is.close();
            os.close();
            oos.close();
        } catch (IOException e) {

        }
    }

    private static byte[] decode(Map<Byte, String> huffmanCodes, byte[] huffmanBytes) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < huffmanBytes.length; i++) {
            byte b = huffmanBytes[i];
            boolean flag = (i == huffmanBytes.length - 1);
            stringBuilder.append(byteToBitString(!flag, b));
        }
        System.out.println(stringBuilder);
        HashMap<String, Byte> map = new HashMap<>();
        for (Map.Entry<Byte, String> entry : huffmanCodes.entrySet()) {
            map.put(entry.getValue(), entry.getKey());
        }
        System.out.println(map);
        ArrayList<Byte> list = new ArrayList<>();
        for (int i = 0; i < stringBuilder.length(); ) {
            int count = 1;
            boolean flag = true;
            Byte b = null;
            while (flag) {

                String key = stringBuilder.substring(i, i + count);
                b = map.get(key);
                if (b == null) {
                    count++;
                } else {
                    flag = false;
                }
            }
            list.add(b);
            i += count;
        }
        byte[] b = new byte[list.size()];
        for (int i = 0; i < b.length; i++) {
            b[i] = list.get(i);
        }
        return b;
    }

    private static String byteToBitString(Boolean flag, byte b) {
        int temp = b;
        if (flag) {
            temp |= 256;
        }
        String str = Integer.toBinaryString(temp);
        if (flag) {
            return str.substring(str.length() - 8);
        } else {
            return str;
        }
    }

    private static byte[] huffmanZip(byte[] bytes) {
        List<Node> nodes = getNode(bytes);
        Node tree = createHuffmanTree(nodes);
        //tree.preOrder();
        getCodes(tree, "", stringBuilder);
        //System.out.println("================================================");
        getCodes(tree, "", stringBuilder);
        //System.out.println("" + huffmanCodes);
        //System.out.println("================================================");
        byte[] huffmanCodeBytes = zip(bytes, huffmanCodes);
        return huffmanCodeBytes;
    }

    private static byte[] zip(byte[] bytes, Map<Byte, String> huffmanCodes) {
        StringBuilder builder = new StringBuilder();
        for (byte b : bytes) {
            //System.out.println("----:" + huffmanCodes.get(b));
            builder.append(huffmanCodes.get(b));
        }
        int len = (builder.length() + 7) / 8;
        byte[] huffmanCodeBytes = new byte[len];
        int index = 0;
        String strByte;
        for (int i = 0; i < builder.length(); i += 8) {
            if (i + 8 > builder.length()) {
                strByte = builder.substring(i);
            } else {
                strByte = builder.substring(i, i + 8);
            }
            huffmanCodeBytes[index++] = (byte) Integer.parseInt(strByte, 2);
        }
        //System.out.println(Arrays.toString(huffmanCodeBytes));
        return huffmanCodeBytes;
    }

    private static List<Node> getNode(byte[] bytes) {
        ArrayList<Node> nodes = new ArrayList<>();
        HashMap<Byte, Integer> counts = new HashMap<>();
        for (byte b : bytes) {
            Integer count = counts.get(b);
            if (count == null) {
                counts.put(b, 1);
            } else {
                counts.put(b, count + 1);
            }
        }
        for (Map.Entry<Byte, Integer> entry : counts.entrySet()) {
            nodes.add(new Node(entry.getKey(), entry.getValue()));
        }
        return nodes;
    }

    private static Node createHuffmanTree(List<Node> nodes) {
        while (nodes.size() > 1) {
            Collections.sort(nodes);
            Node left = nodes.get(0);
            Node right = nodes.get(1);
            Node parents = new Node(null, left.weight + right.weight);
            parents.left = left;
            parents.right = right;
            nodes.remove(left);
            nodes.remove(right);
            nodes.add(parents);
        }
        return nodes.get(0);
    }

    private static void getCodes(Node node, String code, StringBuilder stringBuilder) {
        StringBuilder stringBuilder1 = new StringBuilder(stringBuilder);
        stringBuilder1.append(code);
        if (node != null) {
            if (node.data == null) {
                getCodes(node.left, "0", stringBuilder1);
                getCodes(node.right, "1", stringBuilder1);
            } else {
                huffmanCodes.put(node.data, stringBuilder1.toString());
            }
        }

    }


}

class Node implements Comparable<Node> {
    Byte data;//存放数据(字符)本身，比如'a'=>97 ' '=>32
    int weight;//权值，表示字符出现的次数
    Node left;
    Node right;

    public Node(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        //从小到大排序
        return this.weight - o.weight;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }

    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }


}
