<script>
  //Importing Line class from the vue-chartjs wrapper
  import {Line} from 'vue-chartjs'
  //Exporting this so it can be used in other components
  export default { 
    extends: Line,
    data () {
      return {
        datacollection: {
          //Data to be represented on x-axis
          labels: [this.$store.state.environmentSevendays[6].day_date, this.$store.state.environmentSevendays[5].day_date, this.$store.state.environmentSevendays[4].day_date,
           this.$store.state.environmentSevendays[3].day_date, this.$store.state.environmentSevendays[2].day_date,
           this.$store.state.environmentSevendays[1].day_date, this.$store.state.environmentSevendays[0].day_date], 
          datasets: [
            {
              label: '이전 환경 추이 그래프',
              backgroundColor: '#f87979',
              pointBackgroundColor: 'white',
              borderWidth: 1,
              pointBorderColor: '#249EBF',
              //Data to be represented on y-axis
              data: [this.$store.state.environmentSevendays[6].all_avg_value, this.$store.state.environmentSevendays[5].all_avg_value, this.$store.state.environmentSevendays[4].all_avg_value,
               this.$store.state.environmentSevendays[3].all_avg_value, this.$store.state.environmentSevendays[2].all_avg_value,
               this.$store.state.environmentSevendays[1].all_avg_value, this.$store.state.environmentSevendays[0].all_avg_value]
            }
          ]
        },
        //Chart.js options that controls the appearance of the chart
        options: {
          scales: {
            yAxes: [{
              ticks: {
                beginAtZero: true
              },
              gridLines: {
                display: true
              }
            }],
            xAxes: [ {
              gridLines: {
                display: false
              }
            }]
          },
          legend: {
            display: true
          },
          responsive: true,
          maintainAspectRatio: false
        }
      }
    },
    mounted () {
      //renderChart function renders the chart with the datacollection and options object.
      this.renderChart(this.datacollection, this.options)
    }
  }
</script>
