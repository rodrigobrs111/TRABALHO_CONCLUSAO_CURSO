package dominio



import org.junit.*
import grails.test.mixin.*

/**
 * TrocaControllerTests
 * A unit test class is used to test individual methods or blocks of code without considering the surrounding infrastructure
 */
@TestFor(TrocaController)
@Mock(Troca)
class TrocaControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/troca/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.trocaInstanceList.size() == 0
        assert model.trocaInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.trocaInstance != null
    }

    void testSave() {
        controller.save()

        assert model.trocaInstance != null
        assert view == '/troca/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/troca/show/1'
        assert controller.flash.message != null
        assert Troca.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/troca/list'


        populateValidParams(params)
        def troca = new Troca(params)

        assert troca.save() != null

        params.id = troca.id

        def model = controller.show()

        assert model.trocaInstance == troca
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/troca/list'


        populateValidParams(params)
        def troca = new Troca(params)

        assert troca.save() != null

        params.id = troca.id

        def model = controller.edit()

        assert model.trocaInstance == troca
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/troca/list'

        response.reset()


        populateValidParams(params)
        def troca = new Troca(params)

        assert troca.save() != null

        // test invalid parameters in update
        params.id = troca.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/troca/edit"
        assert model.trocaInstance != null

        troca.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/troca/show/$troca.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        troca.clearErrors()

        populateValidParams(params)
        params.id = troca.id
        params.version = -1
        controller.update()

        assert view == "/troca/edit"
        assert model.trocaInstance != null
        assert model.trocaInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/troca/list'

        response.reset()

        populateValidParams(params)
        def troca = new Troca(params)

        assert troca.save() != null
        assert Troca.count() == 1

        params.id = troca.id

        controller.delete()

        assert Troca.count() == 0
        assert Troca.get(troca.id) == null
        assert response.redirectedUrl == '/troca/list'
    }
}
