package hw3.graph;

/**
 Created by stan on 13.02.15.
 */

public class GraphPresenterTest {

    GraphPresenter graph;

    public void setUp() throws Exception {
        graph = new GraphPresenter();
    }

    public void testPrint() throws Exception {
        graph.print();
    }
}