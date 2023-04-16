import java.util.ArrayList;

class BinarySearchTreeTest {
    public static void main(String[] args) {
        BinarySearchTreeTest bstTest = new BinarySearchTreeTest();
        bstTest.testInsert();
        bstTest.testContain();
        bstTest.testDelete();
        bstTest.testRebalance();
        bstTest.testToString();
        bstTest.testPartition();
    }

    @Test
    void testInsert() {
        BinarySearchTree<Album> bst = new BinarySearchTree<Album>();
        Album album1 = new Album(1, new String[] {"Artist1"}, "Title1", 10);
        Album album2 = new Album(2, new String[] {"Artist2"}, "Title2", 20);
        Album album3 = new Album(3, new String[] {"Artist3"}, "Title3", 30);
        Album album4 = new Album(4, new String[] {"Artist4"}, "Title4", 40);
    
        // Insert first album and check if it exists in the tree
        bst.insert(album1);
        assertTrue(bst.contains(album1));
    
        // Insert second album and check if both exist in the tree
        bst.insert(album2);
        assertTrue(bst.contains(album1));
        assertTrue(bst.contains(album2));
    
        // Insert third album and check if all three exist in the tree
        bst.insert(album3);
        assertTrue(bst.contains(album1));
        assertTrue(bst.contains(album2));
        assertTrue(bst.contains(album3));
    
        // Insert fourth album and check if all four exist in the tree
        bst.insert(album4);
        assertTrue(bst.contains(album1));
        assertTrue(bst.contains(album2));
        assertTrue(bst.contains(album3));
        assertTrue(bst.contains(album4));
    }
    

    @Test
    void testDelete() {
        BinarySearchTree<Album> bst = new BinarySearchTree<Album>();
        Album album1 = new Album(1, new String[] {"Artist1"}, "Title1", 10);
        Album album2 = new Album(2, new String[] {"Artist2"}, "Title2", 20);
        Album album3 = new Album(3, new String[] {"Artist3"}, "Title3", 30);
        Album album4 = new Album(4, new String[] {"Artist4"}, "Title4", 40);
    
        bst.insert(album3);
        bst.insert(album1);
        bst.insert(album4);
        bst.insert(album2);
    
        assertEquals(4, bst.size());
    
        bst.delete(album1);
    
        assertEquals(3, bst.size());
        assertFalse(bst.contains(album1));
        assertTrue(bst.contains(album2));
        assertTrue(bst.contains(album3));
        assertTrue(bst.contains(album4));
    
        bst.delete(album3);
    
        assertEquals(2, bst.size());
        assertFalse(bst.contains(album1));
        assertTrue(bst.contains(album2));
        assertFalse(bst.contains(album3));
        assertTrue(bst.contains(album4));
    
        bst.delete(album4);
    
        assertEquals(1, bst.size());
        assertFalse(bst.contains(album1));
        assertTrue(bst.contains(album2));
        assertFalse(bst.contains(album3));
        assertFalse(bst.contains(album4));
    
        bst.delete(album2);
    
        assertEquals(0, bst.size());
        assertFalse(bst.contains(album1));
        assertFalse(bst.contains(album2));
        assertFalse(bst.contains(album3));
        assertFalse(bst.contains(album4));
    }
    

    private void assertEquals(int i, String size) {
    }

    private void assertEquals(int i, int j) {
    }


    @Test
    void testContain() {
        BinarySearchTree<Album> bst = new BinarySearchTree<>();
        Album album1 = new Album(1, new String[] {"Artist1"}, "Title1", 10);
        Album album2 = new Album(2, new String[] {"Artist2"}, "Title2", 20);

        bst.insert(album2);
        assertFalse(bst.contains(album1));

        bst.insert(album1);
        assertTrue(bst.contains(album1));
    }

    private void assertTrue(boolean contains) {
    }

    private void assertFalse(boolean contains) {
    }

    @Test
    void testToString() {
        BinarySearchTree<Album> bst = new BinarySearchTree<>();
        Album album1 = new Album(1, new String[] {"Artist1"}, "Title1", 10);
        Album album2 = new Album(2, new String[] {"Artist2"}, "Title2", 20);
        Album album3 = new Album(3, new String[] {"Artist3"}, "Title3", 30);
        Album album4 = new Album(4, new String[] {"Artist4"}, "Title4", 40);

        bst.insert(album2);
        bst.insert(album1);
        bst.insert(album4);
        bst.insert(album3);

        assertEquals("1, 2, 3, 4", bst.toString());
    }

    private void assertEquals(String string, String string2) {
    }

    @Test
    void testRebalance() {
        BinarySearchTree<Album> bst = new BinarySearchTree<Album>();
        Album album1 = new Album(1, new String[] {"Artist1"}, "Title1", 10);
        Album album2 = new Album(2, new String[] {"Artist2"}, "Title2", 20);
        Album album3 = new Album(3, new String[] {"Artist3"}, "Title3", 30);
        Album album4 = new Album(4, new String[] {"Artist4"}, "Title4", 40);
        Album album5 = new Album(5, new String[] {"Artist5"}, "Title5", 50);
        
        bst.insert(album1);
        bst.insert(album2);
        bst.insert(album3);
        bst.insert(album4);
        bst.insert(album5);
        
        String expected = "30, 20, 40, 10, 25, 35, 50";
        String actual = bst.toString();
        assertEquals(expected, actual);
        
        BinarySearchTree<Album> balancedBST = bst.rebalance();
        
        expected = "30, 20, 40, 10, 25, 35, 50";
        actual = bst.toString();
        assertEquals(expected, actual); // original tree should remain the same
        
        expected = "30, 20, 40, 10, 25, 35, 50";
        actual = balancedBST.toString();
        assertEquals(expected, actual); // rebalanced tree should match expected string
    }
    @Test
public void testPartition() {
    BinarySearchTree<Album> bst = new BinarySearchTree<>();
    bst.insert(new Album(1, "Album A", new String[]{"Artist A"}, 8));
    bst.insert(new Album(2, "Album B", new String[]{"Artist B"}, 12));
    bst.insert(new Album(3, "Album C", new String[]{"Artist C"}, 6));
    bst.insert(new Album(4, "Album D", new String[]{"Artist D"}, 10));
    bst.insert(new Album(5, "Album E", new String[]{"Artist E"}, 15));
    
    ArrayList<BinarySearchTree<Album>> partitionedList = bst.partition(new Album(3, "", null, 0));
    
    assertEquals(3, partitionedList.size());
    assertEquals("Album A", partitionedList.get(0).getTitle());
    assertEquals("Album B", partitionedList.get(1).getTitle());
    assertEquals("Album D", partitionedList.get(2).getTitle());
}

}    