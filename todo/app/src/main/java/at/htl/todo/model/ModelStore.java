package at.htl.todo.model;
import android.util.Log;

import java.util.Arrays;

import javax.inject.Inject;
import javax.inject.Singleton;
import at.htl.todo.util.store.Store;

@Singleton
public class ModelStore extends Store<Model>  {

    @Inject
    ModelStore() {
        super(Model.class, new Model());
    }

    public void setTodos(Todo[] todos) {
        apply(model -> model.todos = todos);
    }
    public void selectTab(int tabIndex) {
        apply(model -> model.uiState.selectedTab = tabIndex);
    }


    public void updateTodoCompleted(int index, boolean completed) {
        apply(model -> model.todos[index].completed = completed);
        Log.i("ModelStore", "Updated todo at index " + index + " to completed: " + completed);
    }

    public void delete(int index){
        apply(model -> {
            Todo[] todosAll = model.todos;
            // remove element at index
            Todo[] todos = new Todo[todosAll.length - 1];
            System.arraycopy(todosAll, 0, todos, 0, index);
            System.arraycopy(todosAll, index + 1, todos, index, todosAll.length - index - 1);
            model.todos = todos;
        });
    }
}

