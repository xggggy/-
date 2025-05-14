<template>
  <div class="calendar-container">
    <div class="calendar-header">
      <button @click="prevMonth">上一月</button>
      <h2>{{ currentYear }} 年 {{ currentMonth + 1 }} 月</h2>
      <button @click="nextMonth">下一月</button>
    </div>
    <table class="calendar-table">
      <thead>
      <tr>
        <th>周日</th>
        <th>周一</th>
        <th>周二</th>
        <th>周三</th>
        <th>周四</th>
        <th>周五</th>
        <th>周六</th>
      </tr>
      </thead>
      <tbody>
      <tr v-for="(week, weekIndex) in weeks" :key="weekIndex">
        <td v-for="(day, dayIndex) in week" :key="dayIndex" :class="{ 'has-todo': hasTodo(day) }">
          <span>{{ day ? day.getDate() : '' }}</span>
          <ul v-if="hasTodo(day)">
            <li v-for="todo in getTodosForDay(day)" :key="todo.id">{{ todo.title }}</li>
          </ul>
        </td>
      </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
export default {
  data() {
    return {
      currentDate: new Date(),
      todos: []
    };
  },
  computed: {
    currentYear() {
      return this.currentDate.getFullYear();
    },
    currentMonth() {
      return this.currentDate.getMonth();
    },
    weeks() {
      const firstDay = new Date(this.currentYear, this.currentMonth, 1);
      const lastDay = new Date(this.currentYear, this.currentMonth + 1, 0);
      const daysInMonth = lastDay.getDate();
      const startingDay = firstDay.getDay();

      const weeksArray = [];
      let currentWeek = [];

      for (let i = 0; i < startingDay; i++) {
        currentWeek.push(null);
      }

      for (let day = 1; day <= daysInMonth; day++) {
        const currentDateObj = new Date(this.currentYear, this.currentMonth, day);
        currentWeek.push(currentDateObj);

        if (currentWeek.length === 7) {
          weeksArray.push(currentWeek);
          currentWeek = [];
        }
      }

      if (currentWeek.length > 0) {
        while (currentWeek.length < 7) {
          currentWeek.push(null);
        }
        weeksArray.push(currentWeek);
      }

      return weeksArray;
    }
  },
  created() {
    this.$http.get('/yuyuexinxi/rililist', {}).then(res => {
      if (res.data.code == 0) {
        this.detail = res.data.data;
        this.title = this.detail.cheliangmingcheng;
        this.$forceUpdate();
      }
    });
  },
  methods: {
    init(){
      this.$http.get('/yuyuexinxi/rililist', {}).then(res => {
        if (res.data.code == 0) {
          this.detail = res.data.data;
          this.title = this.detail.cheliangmingcheng;
          this.$forceUpdate();
        }
      });
    },
    hasTodo(date) {
      if (!date) return false;
      return this.todos.some(todo => new Date(todo.date).getTime() === date.getTime());
    },
    getTodosForDay(date) {
      return this.todos.filter(todo => new Date(todo.date).getTime() === date.getTime());
    },
    prevMonth() {
      if (this.currentMonth === 0) {
        this.currentDate = new Date(this.currentYear - 1, 11);
      } else {
        this.currentDate = new Date(this.currentYear, this.currentMonth - 1);
      }
      this.fetchTodos();
    },
    nextMonth() {
      if (this.currentMonth === 11) {
        this.currentDate = new Date(this.currentYear + 1, 0);
      } else {
        this.currentDate = new Date(this.currentYear, this.currentMonth + 1);
      }
      this.fetchTodos();
    },
    fetchTodos() {
      /* this.$http.get('/yuyuexinxi/rililist', {
         params: {
         }
       }).then(response => {
         this.todos = response.body;
       }).catch(error => {
         console.error('获取待办事项数据失败:', error);
       });*/
      this.$http.post('/yuyuexinxi/rililist').then(res => {
        if (res.data.code == 0) {
          this.isStoreup = false;
          this.$message({
            type: 'success',
            message: '取消成功!',
            duration: 1500,
          });
        }
      });
    }
  },
};
</script>

<style scoped>
.calendar-container {
  font-family: Arial, sans-serif;
  max-width: 600px;
  margin: 0 auto;
}

.calendar-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 10px;
}

.calendar-table {
  width: 100%;
  border-collapse: collapse;
}

.calendar-table th,
.calendar-table td {
  border: 1px solid #ccc;
  padding: 8px;
  text-align: center;
}

.has-todo {
  background-color: #e0f7fa;
}

.has-todo ul {
  list-style-type: none;
  padding: 0;
  margin: 0;
}

.has-todo li {
  font-size: 0.8em;
}
</style>
