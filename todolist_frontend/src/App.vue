<template>
    <div>
        <div v-for="todo in todos" :key="todo.id">
            <h2>{{ todo.title }}</h2>
            <p>{{ todo.description }}</p>
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
    async created() {
        const response = await axios.get('http://localhost:8080/api/todos');
        this.todos = response.data;
    },
};
</script>