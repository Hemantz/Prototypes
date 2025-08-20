package com.demo.demo.service;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.TreeMap;

import com.google.common.hash.Hashing;


public class ConsistantHashing {
    static TreeMap<BigInteger, String> ring = new TreeMap<>();

    public static void addNode(String node) {
        BigInteger hash = new BigInteger(1, Hashing.sha256().hashString(node, StandardCharsets.UTF_8).asBytes());
        ring.put(hash, node);
    }

    public static String put(String data) {
        BigInteger hash = new BigInteger(1, Hashing.sha256().hashString(data, StandardCharsets.UTF_8).asBytes());
        String node = ring.ceilingEntry(hash).getValue();
        if (node == null) {
            node = ring.firstEntry().getValue();
        }
        return node;
    }

    public static void main(String[] args) {
        addNode("node1");
        addNode("node2");
        addNode("node3");
        addNode("node4");
        System.out.println("saves in node : "+put("order10000")); // saves in node : node1
    }
}
