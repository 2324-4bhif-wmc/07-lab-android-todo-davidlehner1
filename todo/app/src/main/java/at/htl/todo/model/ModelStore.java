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

    public void updateTodoCompleted(int index, boolean completed) {
        apply(model -> model.todos[index].completed = completed);
        Log.i("ModelStore", "Updated todo at index " + index + " to completed: " + completed);
    }
}

