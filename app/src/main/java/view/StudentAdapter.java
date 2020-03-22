package view;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import androidx.core.text.HtmlCompat;
import androidx.recyclerview.widget.RecyclerView;
import edu.montclair.www.course_registration_hannumc1.R;
import database.model.Student;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.MyViewHolder> {

    private Context context;
    private List<Student> studentsList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView student;
        public TextView dot;
        public TextView timestamp;
        public TextView course;
        public TextView priority;

        public MyViewHolder(View view) {
            super(view);
            student = view.findViewById(R.id.student);
            dot = view.findViewById(R.id.dot);
            timestamp = view.findViewById(R.id.timestamp);
            course = view.findViewById(R.id.course);
            priority = view.findViewById(R.id.priority);
        }
    }


    public StudentAdapter(Context context, List<Student> studentsList) {
        this.context = context;
        this.studentsList = studentsList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.student_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Student student = studentsList.get(position);

        holder.student.setText(student.getStudent());

        // Displaying dot from HTML character code
        holder.dot.setText(HtmlCompat.fromHtml("&#8226;", 0));

        // Formatting and displaying timestamp
        holder.timestamp.setText(formatDate(student.getTimestamp()));

        holder.course.setText(student.getCourse());

        holder.priority.setText(String.valueOf(student.getPriority()));
    }

    @Override
    public int getItemCount() {
        return studentsList.size();
    }

    /**
     * Formatting timestamp to `MMM d` format
     * Input: 2018-02-21 00:15:42
     * Output: Feb 21
     */
    private String formatDate(String dateStr) {
        try {
            SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = fmt.parse(dateStr);
            SimpleDateFormat fmtOut = new SimpleDateFormat("MMM d");
            return fmtOut.format(date);
        } catch (ParseException e) {

        }

        return "";
    }
}