package dominio



import org.junit.*
import grails.test.mixin.*

/**
 * GerenteDoVarejistaControllerTests
 * A unit test class is used to test individual methods or blocks of code without considering the surrounding infrastructure
 */
@TestFor(GerenteDoVarejistaController)
@Mock(GerenteDoVarejista)
class GerenteDoVarejistaControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/gerenteDoVarejista/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.gerenteDoVarejistaInstanceList.size() == 0
        assert model.gerenteDoVarejistaInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.gerenteDoVarejistaInstance != null
    }

    void testSave() {
        controller.save()

        assert model.gerenteDoVarejistaInstance != null
        assert view == '/gerenteDoVarejista/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/gerenteDoVarejista/show/1'
        assert controller.flash.message != null
        assert GerenteDoVarejista.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/gerenteDoVarejista/list'


        populateValidParams(params)
        def gerenteDoVarejista = new GerenteDoVarejista(params)

        assert gerenteDoVarejista.save() != null

        params.id = gerenteDoVarejista.id

        def model = controller.show()

        assert model.gerenteDoVarejistaInstance == gerenteDoVarejista
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/gerenteDoVarejista/list'


        populateValidParams(params)
        def gerenteDoVarejista = new GerenteDoVarejista(params)

        assert gerenteDoVarejista.save() != null

        params.id = gerenteDoVarejista.id

        def model = controller.edit()

        assert model.gerenteDoVarejistaInstance == gerenteDoVarejista
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/gerenteDoVarejista/list'

        response.reset()


        populateValidParams(params)
        def gerenteDoVarejista = new GerenteDoVarejista(params)

        assert gerenteDoVarejista.save() != null

        // test invalid parameters in update
        params.id = gerenteDoVarejista.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/gerenteDoVarejista/edit"
        assert model.gerenteDoVarejistaInstance != null

        gerenteDoVarejista.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/gerenteDoVarejista/show/$gerenteDoVarejista.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        gerenteDoVarejista.clearErrors()

        populateValidParams(params)
        params.id = gerenteDoVarejista.id
        params.version = -1
        controller.update()

        assert view == "/gerenteDoVarejista/edit"
        assert model.gerenteDoVarejistaInstance != null
        assert model.gerenteDoVarejistaInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/gerenteDoVarejista/list'

        response.reset()

        populateValidParams(params)
        def gerenteDoVarejista = new GerenteDoVarejista(params)

        assert gerenteDoVarejista.save() != null
        assert GerenteDoVarejista.count() == 1

        params.id = gerenteDoVarejista.id

        controller.delete()

        assert GerenteDoVarejista.count() == 0
        assert GerenteDoVarejista.get(gerenteDoVarejista.id) == null
        assert response.redirectedUrl == '/gerenteDoVarejista/list'
    }
}
