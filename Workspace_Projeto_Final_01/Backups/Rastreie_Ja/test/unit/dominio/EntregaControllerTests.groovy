package dominio



import org.junit.*
import grails.test.mixin.*

/**
 * EntregaControllerTests
 * A unit test class is used to test individual methods or blocks of code without considering the surrounding infrastructure
 */
@TestFor(EntregaController)
@Mock(Entrega)
class EntregaControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/entrega/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.entregaInstanceList.size() == 0
        assert model.entregaInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.entregaInstance != null
    }

    void testSave() {
        controller.save()

        assert model.entregaInstance != null
        assert view == '/entrega/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/entrega/show/1'
        assert controller.flash.message != null
        assert Entrega.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/entrega/list'


        populateValidParams(params)
        def entrega = new Entrega(params)

        assert entrega.save() != null

        params.id = entrega.id

        def model = controller.show()

        assert model.entregaInstance == entrega
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/entrega/list'


        populateValidParams(params)
        def entrega = new Entrega(params)

        assert entrega.save() != null

        params.id = entrega.id

        def model = controller.edit()

        assert model.entregaInstance == entrega
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/entrega/list'

        response.reset()


        populateValidParams(params)
        def entrega = new Entrega(params)

        assert entrega.save() != null

        // test invalid parameters in update
        params.id = entrega.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/entrega/edit"
        assert model.entregaInstance != null

        entrega.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/entrega/show/$entrega.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        entrega.clearErrors()

        populateValidParams(params)
        params.id = entrega.id
        params.version = -1
        controller.update()

        assert view == "/entrega/edit"
        assert model.entregaInstance != null
        assert model.entregaInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/entrega/list'

        response.reset()

        populateValidParams(params)
        def entrega = new Entrega(params)

        assert entrega.save() != null
        assert Entrega.count() == 1

        params.id = entrega.id

        controller.delete()

        assert Entrega.count() == 0
        assert Entrega.get(entrega.id) == null
        assert response.redirectedUrl == '/entrega/list'
    }
}
