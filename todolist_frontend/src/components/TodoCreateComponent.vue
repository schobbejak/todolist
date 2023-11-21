<template>
    <div>
        <h1>Create Todo</h1>
        <form @submit.prevent="createTodo">
            <label>
                Title:
                <input v-model="newTodo.title" required>
            </label>
            <label>
                Description:
                <input v-model="newTodo.description" required>
            </label>
            <label>
                Due Date:
                <input type="date" v-model="newTodo.date" required>
            </label>
            <button type="submit">Create</button>
        </form>
    </div>
</template>

<script>
import axios from 'axios';

export default {
    data() {
        return {
            newTodo: {
                title: '',
                description: '',
                date: '',
                completed: false,
            },
        };
    },
    methods: {
        async createTodo() {
            try {
                const config = {
                    headers: {
                        'Content-Type': 'application/json',
                    },
                };
                await axios.post('http://localhost:8080/api/todos', this.newTodo, config);
                console.log(this.newTodo)
                this.newTodo = { title: '', description: '', date: '', completed: false };
                this.$router.push('/');
            } catch (error) {
                console.log(error);
            }
        },
    },
};
</script>