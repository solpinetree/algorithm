vector<string> bigSorting(vector<string> unsorted) {
    vector<int> sizeSorting;
    vector<string> res;
    int p1=0,p2=0;
    for(int i=0;i<unsorted.size();i++){
        if(find(sizeSorting.begin(),sizeSorting.end(),unsorted[i].size())==sizeSorting.end())
            sizeSorting.push_back(unsorted[i].size());
    }  
    sort(sizeSorting.begin(),sizeSorting.end());
    for(int i=0;i<sizeSorting.size();i++)
    {
        vector<string> samesize; 
        for(int j=0;j<unsorted.size();j++){
            if(unsorted[j].size()==sizeSorting[i])
                samesize.push_back(unsorted[j]);
        }
        // 같은 사이즈의 숫자 문자열끼리는 sort 사용 가능
        sort(samesize.begin(),samesize.end()); 
        for(int j=0;j<samesize.size();j++){
            res.push_back(samesize[j]);
        }
    }
    
    return res;
}
