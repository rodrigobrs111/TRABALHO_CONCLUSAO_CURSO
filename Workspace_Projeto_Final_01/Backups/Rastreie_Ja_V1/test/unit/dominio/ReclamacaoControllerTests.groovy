package dominio



import org.junit.*
import grails.test.mixin.*

/**
 * ReclamacaoControllerTests
 * A unit test class is used to test individual methods or blocks of code without considering the surrounding infrastructure
 */
@TestFor(ReclamacaoController)
@Mock(Reclamacao)
class ReclamacaoControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/reclamacao/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.reclamacaoInstanceList.size() == 0
        assert model.reclamacaoInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.reclamacaoInstance != null
    }

    void testSave() {
        controller.save()

        assert model.reclamacaoInstance != null
        assert view == '/reclamacao/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/reclamacao/show/1'
        assert controller.flash.message != null
        assert Reclamacao.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/reclamacao/list'


        populateValidParams(params)
        def reclamacao = new Reclamacao(params)

        assert reclamacao.save() != null

        params.id = reclamacao.id

        def model = controller.show()

        assert model.reclamacaoInstance == reclamacao
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/reclamacao/list'


        populateValidParams(params)
        def reclamacao = new Reclamacao(params)

        assert reclamacao.save() != null

        params.id = reclamacao.id

        def model = controller.edit()

        assert model.reclamacaoInstance == reclamacao
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/reclamacao/list'

        response.reset()


        populateValidParams(params)
        def reclamacao = new Reclamacao(params)

        assert reclamacao.save() != null

        // test invalid parameters in update
        params.id = reclamacao.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/reclamacao/edit"
        assert model.reclamacaoInstance != null

        reclamacao.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/reclamacao/show/$reclamacao.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        reclamacao.clearErrors()

        populateValidParams(params)
        params.id = reclamacao.id
        params.version = -1
        controller.update()

        assert view == "/reclamacao/edit"
        assert model.reclamacaoInstance != null
        assert model.reclamacaoInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/reclamacao/list'

        response.reset()

        populateValidParams(params)
        def reclamacao = new Reclamacao(params)

        assert reclamacao.save() != null
        assert Reclamacao.count() == 1

        params.id = reclamacao.id

        controller.delete()

        assert Reclamacao.count() == 0
        assert Reclamacao.get(reclamacao.id) == null
        assert response.redirectedUrl == '/reclamacao/list'
    }
}
