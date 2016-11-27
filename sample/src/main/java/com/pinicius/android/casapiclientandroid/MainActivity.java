package com.pinicius.android.casapiclientandroid;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.pinicius.android.casapiclient.CASApiConfig;
import com.pinicius.android.casapiclient.CASApiException;
import com.pinicius.android.casapiclient.RoomApiClient;
import com.pinicius.android.casapiclient.SessionApiClient;
import com.pinicius.android.casapiclient.SpeakerApiClient;
import com.pinicius.android.casapiclient.TagApiClient;
import com.pinicius.android.casapiclient.model.RoomDto;
import com.pinicius.android.casapiclient.model.SessionDto;
import com.pinicius.android.casapiclient.model.SpeakerDto;
import com.pinicius.android.casapiclient.model.TagDto;

import java.util.Collection;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "Testing GET All Sessions Api Call");
        new MakeAllSessionsApiCall().execute();

//        Log.d(TAG, "Testing GET Session Api Call");
//        new MakeSessionApiCall().execute(7);

//        Log.d(TAG, "Testing GET All Speakers Api Call");
//        new MakeAllSpeakersApiCall().execute();

//        Log.d(TAG, "Testing GET Speaker Api Call");
//        new MakeSpeakerApiCall().execute(5);

//        Log.d(TAG, "Testing GET All Rooms Api Call");
//        new MakeAllRoomsApiCall().execute();

//        Log.d(TAG, "Testing GET Room Api Call");
//        new MakeRoomApiCall().execute(2);

//        Log.d(TAG, "Testing GET All Tags Api Call");
//        new MakeAllTagsApiCall().execute();

//        Log.d(TAG, "Testing GET Tag Sessions Api Call");
//        new MakeTagSessionsApiCall().execute("scrum");
    }

    private class MakeAllSessionsApiCall extends AsyncTask<Void, Void, Collection<SessionDto>> {

        @Override
        protected Collection<SessionDto> doInBackground(Void... params) {
            CASApiConfig casApiConfig = new CASApiConfig.Builder().debug(true).build();
            SessionApiClient sessionApiClient = new SessionApiClient(casApiConfig);
            Collection<SessionDto> sessions;
            try {
                sessions = sessionApiClient.getAll();
            } catch (CASApiException e) {
                sessions = null;
                Log.d(TAG, "Error obtaining all sessions info. Message: " + e.getMessage());
                e.printStackTrace();
            }
            return sessions;
        }

        @Override
        protected void onPostExecute(Collection<SessionDto> sessions) {
            for (SessionDto session : sessions) {
                Log.d(TAG, "Session: " + session.toString());
            }
        }
    }

    private class MakeSessionApiCall extends AsyncTask<Integer, Void, SessionDto> {

        @Override
        protected SessionDto doInBackground(Integer... params) {
            CASApiConfig casApiConfig = new CASApiConfig.Builder().debug(true).build();
            SessionApiClient sessionApiClient = new SessionApiClient(casApiConfig);
            SessionDto session;
            try {
                session = sessionApiClient.getSession(params[0]);
            } catch (CASApiException e) {
                session = null;
                Log.d(TAG, "Error obtaining session info. Message: " + e.getMessage());
                e.printStackTrace();
            }
            return session;
        }

        @Override
        protected void onPostExecute(SessionDto sessionDto) {
            if(sessionDto != null)
                Log.d(TAG, "Session info: " + sessionDto.toString());
        }
    }

    private class MakeAllSpeakersApiCall extends AsyncTask<Void, Void, Collection<SpeakerDto>> {

        @Override
        protected Collection<SpeakerDto> doInBackground(Void... params) {
            CASApiConfig casApiConfig = new CASApiConfig.Builder().debug(true).build();
            SpeakerApiClient speakerApiClient = new SpeakerApiClient(casApiConfig);
            Collection<SpeakerDto> speakers;
            try {
                speakers = speakerApiClient.getAll();
            } catch (CASApiException e) {
                speakers = null;
                Log.d(TAG, "Error obtaining all speakers info. Message: " + e.getMessage());
                e.printStackTrace();
            }
            return speakers;
        }

        @Override
        protected void onPostExecute(Collection<SpeakerDto> speakers) {
            for (SpeakerDto speaker : speakers) {
                Log.d(TAG, "Speaker: " + speaker.toString());
            }
        }
    }

    private class MakeSpeakerApiCall extends AsyncTask<Integer, Void, SpeakerDto> {

        @Override
        protected SpeakerDto doInBackground(Integer... params) {
            CASApiConfig casApiConfig = new CASApiConfig.Builder().debug(true).build();
            SpeakerApiClient speakerApiClient = new SpeakerApiClient(casApiConfig);
            SpeakerDto speaker;
            try {
                speaker = speakerApiClient.getSpeaker(params[0]);
            } catch (CASApiException e) {
                speaker = null;
                Log.d(TAG, "Error obtaining speaker info. Message: " + e.getMessage());
                e.printStackTrace();
            }
            return speaker;
        }

        @Override
        protected void onPostExecute(SpeakerDto speakerDto) {
            if(speakerDto != null)
                Log.d(TAG, "Session info: " + speakerDto.toString());
        }
    }

    private class MakeAllRoomsApiCall extends AsyncTask<Void, Void, Collection<RoomDto>> {

        @Override
        protected Collection<RoomDto> doInBackground(Void... params) {
            CASApiConfig casApiConfig = new CASApiConfig.Builder().debug(true).build();
            RoomApiClient roomApiClient = new RoomApiClient(casApiConfig);
            Collection<RoomDto> rooms;
            try {
                rooms = roomApiClient.getAll();
            } catch (CASApiException e) {
                rooms = null;
                Log.d(TAG, "Error obtaining all rooms info. Message: " + e.getMessage());
                e.printStackTrace();
            }
            return rooms;
        }

        @Override
        protected void onPostExecute(Collection<RoomDto> rooms) {
            for (RoomDto room : rooms) {
                Log.d(TAG, "Room: " + room.toString());
            }
        }
    }

    private class MakeRoomApiCall extends AsyncTask<Integer, Void, RoomDto> {

        @Override
        protected RoomDto doInBackground(Integer... params) {
            CASApiConfig casApiConfig = new CASApiConfig.Builder().debug(true).build();
            RoomApiClient roomApiClient = new RoomApiClient(casApiConfig);
            RoomDto room;
            try {
                room = roomApiClient.getRoom(params[0]);
            } catch (CASApiException e) {
                room = null;
                Log.d(TAG, "Error obtaining room info. Message: " + e.getMessage());
                e.printStackTrace();
            }
            return room;
        }

        @Override
        protected void onPostExecute(RoomDto roomDto) {
            if(roomDto != null)
                Log.d(TAG, "Session info: " + roomDto.toString());
        }
    }

    private class MakeAllTagsApiCall extends AsyncTask<Void, Void, Collection<TagDto>> {

        @Override
        protected Collection<TagDto> doInBackground(Void... params) {
            CASApiConfig casApiConfig = new CASApiConfig.Builder().debug(true).build();
            TagApiClient tagApiClient = new TagApiClient(casApiConfig);
            Collection<TagDto> tags;
            try {
                tags = tagApiClient.getAll();
            } catch (CASApiException e) {
                tags = null;
                Log.d(TAG, "Error obtaining all tags info. Message: " + e.getMessage());
                e.printStackTrace();
            }
            return tags;
        }

        @Override
        protected void onPostExecute(Collection<TagDto> tags) {
            for (TagDto tag : tags) {
                Log.d(TAG, "Tag: " + tag.toString());
            }
        }
    }

    private class MakeTagSessionsApiCall extends AsyncTask<String, Void, Collection<SessionDto>> {

        @Override
        protected Collection<SessionDto> doInBackground(String... params) {
            CASApiConfig casApiConfig = new CASApiConfig.Builder().debug(true).build();
            TagApiClient tagApiClient = new TagApiClient(casApiConfig);
            Collection<SessionDto> tagSessions;
            try {
                tagSessions = tagApiClient.getTagSessions(params[0]);
            } catch (CASApiException e) {
                tagSessions = null;
                Log.d(TAG, "Error obtaining tag sessions info. Message: " + e.getMessage());
                e.printStackTrace();
            }
            return tagSessions;
        }

        @Override
        protected void onPostExecute(Collection<SessionDto> tagSessions) {
            Log.d(TAG, "Tag Sessions info: ");
            for(SessionDto tagSession : tagSessions) {
                Log.d(TAG, "Tag Session info: "
                        + '\n'
                        + tagSession.toString()
                        + '\n');
            }
        }
    }
}
