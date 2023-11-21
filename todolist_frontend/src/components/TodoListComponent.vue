<template>
    <div class="container">
        <div class="header">
            <h1>Todo List</h1>
            <router-link to="/create">
                <button class="new">+</button>
            </router-link>
        </div>
        <div class="list">
            <li v-for="todo in nonCompletedTodos" :key="todo.id">
                <div class="todoItem">
                    <input type="checkbox" v-model="todo.completed" @change="updateTodo(todo)">
                    <div>
                        <h3>{{ todo.title }} - {{ todo.date }} </h3>
                        {{ todo.description }}
                    </div>
                    <button @click="deleteTodo(todo.id)">Delete</button>
                </div>
                
            </li>
        </div>
        <div class="header">
            <h1>Completed</h1>
        </div>
        <div class="list">
            <li v-for="todo in completedTodos" :key="todo.id">
                <div class="todoItem">
                    <input type="checkbox" v-model="todo.completed" @change="updateTodo(todo)">
                    <div>
                        <h3>{{ todo.title }} - {{ todo.date }} </h3>
                        {{ todo.description }}
                    </div>
                    <button @click="deleteTodo(todo.id)">Delete</button>
                </div>
            </li>
        </div>
    </div>
</template>

<script>
import axios from 'axios';

export default {
    data() {
        return {
            todos: [],
        };
    },
    computed: {
        completedTodos() {
            return this.todos.filter(todo => todo.completed);
        },
        nonCompletedTodos() {
            return this.todos.filter(todo => !todo.completed).sort((a, b) => new Date(a.date) - new Date(b.date));
        },
    },
    async created() {
        const response = await axios.get('http://localhost:8080/api/todos');
        this.todos = response.data;
    },
    methods: {
        async deleteTodo(id) {
            try {
                await axios.delete(`http://localhost:8080/api/todos/${id}`);
                this.todos = this.todos.filter(todo => todo.id !== id);
            } catch (error) {
                console.error(error);
            }
        },
        async updateTodo (todo) {
            try {
                const config = {
                    headers: {
                        'Content-Type': 'application/json',
                    },
                };
                await axios.put(`http://localhost:8080/api/todos/${todo.id}`, todo, config);
            } catch (error) {
                console.error(error);
            }
        },
    },
};
</script>

<style scoped>
.container {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
}

.todoItem {
    display: flex;
    flex-direction: row;
    align-items: center;
    justify-content: space-between;

}

.header {
    display: flex;
    align-items: center;
    justify-content: space-between;
    width: 100%;
}

.list {
    display: flex;
    flex-direction: column;
    align-items: left;
    justify-content: left;
}

.new {
    color: #006ce4;
    font-size: 3em;
    font-family: BlinkMacSystemFont,-apple-system,Segoe UI,Roboto,Helvetica,Arial,sans-serif;
    width: 1em;
    height: 1em;
    align-items: center;
    justify-content: center;
    display: flex;
    border-radius: 50%;
    
    background-color: #ffffff; /* Change this to your preferred color */
}

.new:hover {
    background-color: #e6e6e6;
}

.new:active {
    background-color: #cccccc;
    transform: scale(0.9);
}

input {
    margin: 0.5rem;
}

li {
    list-style-type: none;
    padding: 0;
}


</style>