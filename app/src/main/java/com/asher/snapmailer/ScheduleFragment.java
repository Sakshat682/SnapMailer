package com.asher.snapmailer;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class ScheduleFragment extends Fragment {

    public ScheduleFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_schedule, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = view.findViewById(R.id.scheduleRecyclerview);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(manager);

        List<ScheduleModel> list = new ArrayList<>();

        list.add(new ScheduleModel("Reciever : Harsh", "29/06/21  11:30","09:07", R.drawable.ic_baseline_person_24));
        list.add(new ScheduleModel("Reciever : Harsh", "29/06/21  11:30","09:07", R.drawable.ic_baseline_person_24));
        list.add(new ScheduleModel("Reciever : Harsh", "29/06/21  11:30","09:07", R.drawable.ic_baseline_person_24));
        list.add(new ScheduleModel("Reciever : Harsh", "29/06/21  11:30","09:07", R.drawable.ic_baseline_person_24));
        list.add(new ScheduleModel("Reciever : Harsh", "29/06/21  11:30","09:07", R.drawable.ic_baseline_person_24));
        list.add(new ScheduleModel("Reciever : Harsh", "29/06/21  11:30","09:07", R.drawable.ic_baseline_person_24));
        list.add(new ScheduleModel("Reciever : Harsh", "29/06/21  11:30","09:07", R.drawable.ic_baseline_person_24));
        list.add(new ScheduleModel("Reciever : Harsh", "29/06/21  11:30","09:07", R.drawable.ic_baseline_person_24));



        ScheduleAdapter adapter = new ScheduleAdapter(list);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}