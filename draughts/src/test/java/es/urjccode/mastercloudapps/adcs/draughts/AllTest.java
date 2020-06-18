package es.urjccode.mastercloudapps.adcs.draughts;

import es.urjccode.mastercloudapps.adcs.draughts.controllers.AllControllerTest;
import es.urjccode.mastercloudapps.adcs.draughts.models.AllModelTest;
import es.urjccode.mastercloudapps.adcs.draughts.views.AllViewTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    AllModelTest.class,
    AllControllerTest.class,
    AllViewTest.class } )
public final class AllTest {
}
