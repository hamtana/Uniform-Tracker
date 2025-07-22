// Table filter that will filter by using components retrieved from the data in the database

export default function FilterTable({sizeTerm, onSearch}){
    return(
        <input type="text" placeholder="Filter by Size..." value={sizeTerm} onChange={(e) => onSearch(e.target.value)}
        style={{ padding: '8px', width: '300px', marginBottom: '20px' }} />
    );
}