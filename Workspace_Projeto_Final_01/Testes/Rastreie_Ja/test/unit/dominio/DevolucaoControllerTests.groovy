package dominio



import org.junit.*
import grails.test.mixin.*

/**
 * DevolucaoControllerTests
 * A unit test class is used to test individual methods or blocks of code without considering the surrounding infrastructure
 */
@TestFor(DevolucaoController)
@Mock(Devolucao)
class DevolucaoControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/devolucao/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.devolucaoInstanceList.size() == 0
        assert model.devolucaoInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.devolucaoInstance != null
    }

    void testSave() {
        controller.save()

        assert model.devolucaoInstance != null
        assert view == '/devolucao/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/devolucao/show/1'
        assert controller.flash.message != null
        assert Devolucao.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/devolucao/list'


        populateValidParams(params)
        def devolucao = new Devolucao(params)

        assert devolucao.save() != null

        params.id = devolucao.id

        def model = controller.show()

        assert model.devolucaoInstance == devolucao
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/devolucao/list'


        populateValidParams(params)
        def devolucao = new Devolucao(params)

        assert devolucao.save() != null

        params.id = devolucao.id

        def model = controller.edit()

        assert model.devolucaoInstance == devolucao
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/devolucao/list'

        response.reset()


        populateValidParams(params)
        def devolucao = new Devolucao(params)

        assert devolucao.save() != null

        // test invalid parameters in update
        params.id = devolucao.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/devolucao/edit"
        assert model.devolucaoInstance != null

        devolucao.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/devolucao/show/$devolucao.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        devolucao.clearErrors()

        populateValidParams(params)
        params.id = devolucao.id
        params.version = -1
        controller.update()

        assert view == "/devolucao/edit"
        assert model.devolucaoInstance != null
        assert model.devolucaoInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/devolucao/list'

        response.reset()

        populateValidParams(params)
        def devolucao = new Devolucao(params)

        assert devolucao.save() != null
        assert Devolucao.count() == 1

        params.id = devolucao.id

        controller.delete()

        assert Devolucao.count() == 0
        assert Devolucao.get(devolucao.id) == null
        assert response.redirectedUrl == '/devolucao/list'
    }
}
