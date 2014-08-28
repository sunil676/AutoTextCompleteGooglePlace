AutoTextCompleteGooglePlace
===========================

This Android project is based on the AutoTextComplete when anyone type inside the edittext. Here I added the Google Places that available for filter from Google API.


Properties:


  Replace your Google API key here.
	private static final String API_KEY = "Google API Key";
	
XML:

	  <AutoCompleteTextView
        android:id="@+id/autoCompleteTextView_test"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Enter location"
        android:ems="10" >
    </AutoCompleteTextView>
	
JAVA:

You need to implements the Filterable Class and its override method:

    @Override
    public int getCount() {
        return resultList.size();
    }

    @Override
    public String getItem(int index) {
        return resultList.get(index);
    }

  
    
    @Override
    public Filter getFilter() {
        Filter filter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults filterResults = new FilterResults();
                if (constraint != null) {
                    // Retrieve the autocomplete results.
                    resultList = autocomplete(constraint.toString());

                    // Assign the data to the FilterResults
                    filterResults.values = resultList;
                    filterResults.count = resultList.size();
                }
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                if (results != null && results.count > 0) {
                    notifyDataSetChanged();
                }
                else {
                    notifyDataSetInvalidated();
                }
            }};
        return filter;
    }
    
    
Copyright 2014 Sunil Gupta

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
