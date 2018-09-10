package dominio



import org.junit.*
import grails.test.mixin.*

/**
 * PedidoControllerTests
 * A unit test class is used to test individual methods or blocks of code without considering the surrounding infrastructure
 */
@TestFor(PedidoController)
@Mock(Pedido)
class PedidoControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/pedido/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.pedidoInstanceList.size() == 0
        assert model.pedidoInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.pedidoInstance != null
    }

    void testSave() {
        controller.save()

        assert model.pedidoInstance != null
        assert view == '/pedido/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/pedido/show/1'
        assert controller.flash.message != null
        assert Pedido.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/pedido/list'


        populateValidParams(params)
        def pedido = new Pedido(params)

        assert pedido.save() != null

        params.id = pedido.id

        def model = controller.show()

        assert model.pedidoInstance == pedido
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/pedido/list'


        populateValidParams(params)
        def pedido = new Pedido(params)

        assert pedido.save() != null

        params.id = pedido.id

        def model = controller.edit()

        assert model.pedidoInstance == pedido
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/pedido/list'

        response.reset()


        populateValidParams(params)
        def pedido = new Pedido(params)

        assert pedido.save() != null

        // test invalid parameters in update
        params.id = pedido.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/pedido/edit"
        assert model.pedidoInstance != null

        pedido.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/pedido/show/$pedido.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        pedido.clearErrors()

        populateValidParams(params)
        params.id = pedido.id
        params.version = -1
        controller.update()

        assert view == "/pedido/edit"
        assert model.pedidoInstance != null
        assert model.pedidoInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/pedido/list'

        response.reset()

        populateValidParams(params)
        def pedido = new Pedido(params)

        assert pedido.save() != null
        assert Pedido.count() == 1

        params.id = pedido.id

        controller.delete()

        assert Pedido.count() == 0
        assert Pedido.get(pedido.id) == null
        assert response.redirectedUrl == '/pedido/list'
    }
}
