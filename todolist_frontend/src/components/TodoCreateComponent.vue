<template>
    <div>
        <h1>Create Todo</h1>
        <form @submit.prevent="createTodo">
            <div class="field">
                <label>
                    Title:
                    <input v-model="newTodo.title" required>
                </label>
            </div>
            <div class="field">
                <label>
                    Description:
                    <input v-model="newTodo.description" required>
                </label>
            </div>
            <div class="field">
                <label>
                    Due Date:
                    <input type="date" v-model="newTodo.date">
                </label>
            </div>
            <button type="submit">Create</button>
            <button type="button" @click="$router.push('/')">Cancel</button>
        </form>
    </div>
</template>

<style>
    .field {
        display: flex;
        flex-direction: column;
        margin-bottom: 1rem;
    }
</style>

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