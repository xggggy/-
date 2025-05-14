<template>
  <div class="calendar">
    <div class="month-navigation">
      <button @click="prevMonth">上一月</button>
      <span>{{ currentYear }}年{{ currentMonth + 1 }}月</span>
      <button @click="nextMonth">下一月</button>
    </div>
    <table>
      <thead>
      <tr>
        <th v-for="day in daysOfWeek" :key="day">{{ day }}</th>
      </tr>
      </thead>
      <tbody>
      <tr v-for="(week, weekIndex) in calendarGrid" :key="weekIndex">
        <td
            v-for="(day, dayIndex) in week"
            :key="dayIndex"
            :class="{ 'not-current-month': !isCurrentMonth(day), 'has-todo': hasTodo(day) }"
        >
          <div class="date">{{ day ? day.getDate() : '' }}</div>
          <div class="todo-list">
            <div v-for="todo in getTodosForDay(day)" :key="todo.id">{{ todo.title }}</div>
          </div>
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
      currentYear: new Date().getFullYear(),
      currentMonth: new Date().getMonth(),
      todos: [],
      daysOfWeek: ['日', '一', '二', '三', '四', '五', '六'],
    };
  },
  computed: {
    // 构建日历网格
    calendarGrid() {
      const firstDayOfMonth = new Date(this.currentYear, this.currentMonth, 1);
      const lastDayOfMonth = new Date(this.currentYear, this.currentMonth + 1, 0);
      const startDay = firstDayOfMonth.getDay();
      const totalDays = lastDayOfMonth.getDate();

      const grid = [];
      let week = [];

      // 填充上个月的空白
      for (let i = 0; i < startDay; i++) {
        week.push(null);
      }

      // 填充当前月的日期
      for (let day = 1; day <= totalDays; day++) {
        week.push(new Date(this.currentYear, this.currentMonth, day));
        if (week.length === 7) {
          grid.push(week);
          week = [];
        }
      }

      // 填充下个月的空白
      if (week.length > 0) {
        while (week.length < 7) {
          week.push(null);
        }
        grid.push(week);
      }

      return grid;
    },
  },
  methods: {
    init() {
      this.baseUrl = this.$config.baseUrl;
      if(this.$route.query.detailObj) {
        this.detail = JSON.parse(this.$route.query.detailObj);
      }
      if(this.$route.query.storeupObj) {
        this.detail.id = JSON.parse(this.$route.query.storeupObj).refid;
      }
      const month = String(this.currentMonth + 1).padStart(2, '0');
      const year = this.currentYear;
      this.$http.get('yuyuexinxi/rililist/'+year+'/'+month, {}).then(res => {
        if (res.data.code == 0) {
          this.todos = res.data.data;
          this.$forceUpdate();
        }
      });

      // this.getDiscussList(1);
      // this.getStoreupStatus();
      // this.getThumbsupOrCrazilyStatus();

    },
    // 获取某天的待办事项
    getTodosForDay(day) {
      if (!day || !this.isCurrentMonth(day)) return [];
      return this.todos.filter(
          (todo) =>
              todo.date === `${this.currentYear}-${String(this.currentMonth + 1).padStart(2, '0')}-${String(day.getDate()).padStart(2, '0')}`
      );
    },
    // 判断是否为当前月的日期
    isCurrentMonth(day) {
      return day && day.getMonth() === this.currentMonth;
    },
    // 判断某天是否有待办事项
    hasTodo(day) {
      return this.getTodosForDay(day).length > 0;
    },
    // 上一月
    prevMonth() {
      if (this.currentMonth === 0) {
        this.currentYear--;
        this.currentMonth = 11;
      } else {
        this.currentMonth--;
      }
      this.fetchTodos();
    },
    // 下一月
    nextMonth() {
      if (this.currentMonth === 11) {
        this.currentYear++;
        this.currentMonth = 0;
      } else {
        this.currentMonth++;
      }
      this.fetchTodos();
    },
    // 从后端获取待办事项
    fetchTodos() {
      const month = String(this.currentMonth + 1).padStart(2, '0');
      const year = this.currentYear;
      console.log("month::"+month+"----year::"+year)
      this.$http.get('yuyuexinxi/rililist/'+this.currentYear+'/'+this.currentMonth+1, {}).then(res => {
        if (res.data.code == 0) {
          this.todos = res.data.data;
          this.$forceUpdate();
        }
      });
    },
  },
  created() {
    this.init();
  },
};
</script>

<style scoped>
.calendar {
  max-width: 800px;
  margin: 0 auto;
}

.month-navigation {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 20px;
}

table {
  width: 100%;
  border-collapse: collapse;
}

thead th {
  padding: 10px;
  background-color: #f4f4f4;
}

tbody td {
  position: relative;
  padding: 10px;
  border: 1px solid #ddd;
  height: 100px;
  vertical-align: top;
}

.date {
  font-weight: bold;
  margin-bottom: 5px;
}

.todo-list {
  font-size: 11px;
}

.not-current-month {
  color: #ccc;
}

.has-todo {
  width: 70px;
  background-color: #e6f7ff;
}
</style>
