package com.gethro.gymappfinalproj

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WorkoutSelectionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_workout_selection)

        val workoutList = findViewById<RecyclerView>(R.id.workout_list)
        workoutList.adapter = WorkoutAdapter()
    }

    fun launchHome(view: View) {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }

    private inner class WorkoutAdapter : RecyclerView.Adapter<WorkoutViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkoutViewHolder {
            val view = layoutInflater.inflate(R.layout.workout_item, parent, false)
            return WorkoutViewHolder(view)
        }

        override fun onBindViewHolder(holder: WorkoutViewHolder, position: Int) {
            holder.bind(position)
        }

        override fun getItemCount(): Int {
            return 10 // replace with the number of workout options you want to display
        }
    }

    private inner class WorkoutViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val workoutImage: ImageView = itemView.findViewById(R.id.workout_image)
        private val workoutName: TextView = itemView.findViewById(R.id.workout_name)

        fun bind(position: Int) {
            // replace with data from a list or database
            val workoutNameText = "Workout $position"
            val workoutImageResId = R.drawable.workout_icon

            workoutName.text = workoutNameText
            workoutImage.setImageResource(workoutImageResId)
        }
    }
}

