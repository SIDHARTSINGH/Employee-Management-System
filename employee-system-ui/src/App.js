
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import './App.css';
import AddEmployee from './components/AddEmployee';
import EmployeeList from './components/EmployeeList';
import Navbar from './components/Navbar';

function App() {
  return (
    <>
		<BrowserRouter>
			<Navbar />
			<Routes>
				<Route index element={<EmployeeList />}></Route>
				<Route path="/" element={<EmployeeList />} />
				<Route path="/employeeList" element={<EmployeeList />} />
				<Route path="/addEmployee" element={<AddEmployee />} />
			</Routes>
		</BrowserRouter>
    </>
  );
}

/*
	<BrowserRouter>
		<Navbar />
		<Routes>
			<Navbar />
			<Route index element={<p>Hello</p>} />
			<Route path="/" element={<EmployeeList />} />
			<Route path="/employeeList" element={<EmployeeList />} />
			<Route path="/addEmployee" element={<AddEmployee />} />
		</Routes>
	</BrowserRouter>
*/

export default App;
