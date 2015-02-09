package hw3.graph;

public class GraphPresenterTest {

    GraphPresenter graph;

    public void setUp() throws Exception {
        graph = new GraphPresenter();
    }

    public void testPrint() throws Exception {
        graph.print();
    }
}