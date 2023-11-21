<template>
    <div>
        <h1>Todo List</h1>
        <ul>
            <li v-for="todo in todos" :key="todo.id">
                {{ todo.title }}
                <button @click="deleteTodo(todo.id)">Delete</button>
            </li>
        </ul>
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
    },
};
</script>