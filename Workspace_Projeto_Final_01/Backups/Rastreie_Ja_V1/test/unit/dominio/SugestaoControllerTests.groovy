package dominio



import org.junit.*
import grails.test.mixin.*

/**
 * SugestaoControllerTests
 * A unit test class is used to test individual methods or blocks of code without considering the surrounding infrastructure
 */
@TestFor(SugestaoController)
@Mock(Sugestao)
class SugestaoControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/sugestao/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.sugestaoInstanceList.size() == 0
        assert model.sugestaoInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.sugestaoInstance != null
    }

    void testSave() {
        controller.save()

        assert model.sugestaoInstance != null
        assert view == '/sugestao/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/sugestao/show/1'
        assert controller.flash.message != null
        assert Sugestao.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/sugestao/list'


        populateValidParams(params)
        def sugestao = new Sugestao(params)

        assert sugestao.save() != null

        params.id = sugestao.id

        def model = controller.show()

        assert model.sugestaoInstance == sugestao
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/sugestao/list'


        populateValidParams(params)
        def sugestao = new Sugestao(params)

        assert sugestao.save() != null

        params.id = sugestao.id

        def model = controller.edit()

        assert model.sugestaoInstance == sugestao
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/sugestao/list'

        response.reset()


        populateValidParams(params)
        def sugestao = new Sugestao(params)

        assert sugestao.save() != null

        // test invalid parameters in update
        params.id = sugestao.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/sugestao/edit"
        assert model.sugestaoInstance != null

        sugestao.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/sugestao/show/$sugestao.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        sugestao.clearErrors()

        populateValidParams(params)
        params.id = sugestao.id
        params.version = -1
        controller.update()

        assert view == "/sugestao/edit"
        assert model.sugestaoInstance != null
        assert model.sugestaoInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/sugestao/list'

        response.reset()

        populateValidParams(params)
        def sugestao = new Sugestao(params)

        assert sugestao.save() != null
        assert Sugestao.count() == 1

        params.id = sugestao.id

        controller.delete()

        assert Sugestao.count() == 0
        assert Sugestao.get(sugestao.id) == null
        assert response.redirectedUrl == '/sugestao/list'
    }
}
