package dominio



import org.junit.*
import grails.test.mixin.*

/**
 * ConsumidorControllerTests
 * A unit test class is used to test individual methods or blocks of code without considering the surrounding infrastructure
 */
@TestFor(ConsumidorController)
@Mock(Consumidor)
class ConsumidorControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/consumidor/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.consumidorInstanceList.size() == 0
        assert model.consumidorInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.consumidorInstance != null
    }

    void testSave() {
        controller.save()

        assert model.consumidorInstance != null
        assert view == '/consumidor/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/consumidor/show/1'
        assert controller.flash.message != null
        assert Consumidor.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/consumidor/list'


        populateValidParams(params)
        def consumidor = new Consumidor(params)

        assert consumidor.save() != null

        params.id = consumidor.id

        def model = controller.show()

        assert model.consumidorInstance == consumidor
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/consumidor/list'


        populateValidParams(params)
        def consumidor = new Consumidor(params)

        assert consumidor.save() != null

        params.id = consumidor.id

        def model = controller.edit()

        assert model.consumidorInstance == consumidor
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/consumidor/list'

        response.reset()


        populateValidParams(params)
        def consumidor = new Consumidor(params)

        assert consumidor.save() != null

        // test invalid parameters in update
        params.id = consumidor.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/consumidor/edit"
        assert model.consumidorInstance != null

        consumidor.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/consumidor/show/$consumidor.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        consumidor.clearErrors()

        populateValidParams(params)
        params.id = consumidor.id
        params.version = -1
        controller.update()

        assert view == "/consumidor/edit"
        assert model.consumidorInstance != null
        assert model.consumidorInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/consumidor/list'

        response.reset()

        populateValidParams(params)
        def consumidor = new Consumidor(params)

        assert consumidor.save() != null
        assert Consumidor.count() == 1

        params.id = consumidor.id

        controller.delete()

        assert Consumidor.count() == 0
        assert Consumidor.get(consumidor.id) == null
        assert response.redirectedUrl == '/consumidor/list'
    }
}
