<template>

    <v-data-table
        :headers="headers"
        :items="mybookuser"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'MybookuserView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
                { text: "userId", value: "userId" },
                { text: "orderId", value: "orderId" },
                { text: "bookName", value: "bookName" },
                { text: "qty", value: "qty" },
                { text: "orderDate", value: "orderDate" },
                { text: "orderStatus", value: "orderStatus" },
                { text: "deliveryStatus", value: "deliveryStatus" },
                { text: "deliveryDate", value: "deliveryDate" },
            ],
            mybookuser : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/mybookusers'))

            temp.data._embedded.mybookusers.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.mybookuser = temp.data._embedded.mybookusers;
        },
        methods: {
        }
    }
</script>

