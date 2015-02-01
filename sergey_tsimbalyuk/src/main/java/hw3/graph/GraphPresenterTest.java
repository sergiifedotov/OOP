package hw3.graph;

import org.junit.Before;
import org.junit.Test;

public class GraphPresenterTest {

    GraphPresenter graph;

    @Before
    public void setUp() throws Exception {

        graph = new GraphPresenter();

    }

    @Test
    public void testPrint() throws Exception {
        graph.print();
    }
}