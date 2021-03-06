'use strict';

const React = require('react'); 
const ReactDOM = require('react-dom'); 
const client = require('./client');


class App extends React.Component {

	constructor(props) {
		super(props);
		this.state = {persons: []};
	}

	componentDidMount() { 
		client({method: 'GET', path: '/api/persons'}).done(response => {
			this.setState({persons: response.entity._embedded.persons});
		});
	}

	render() { // <3>
		return (
			<PersonList persons={this.state.persons}/>
		)
	}
}

class PersonList extends React.Component{
	render() {
		const persons = this.props.persons.map(person =>
			<Person key={person._links.self.href} person={person}/>
		);
		return (
			<table>
				<tbody>
					<tr>
						<th>Name</th>
						<th>Score</th>
						<th>Name</th>
						<th>Score</th>
						<th>Name</th>
						<th>Score</th>
						<th>Name</th>
						<th>Score</th>
					</tr>
					{persons}
				</tbody>
			</table>
		)
	}
}


class Person extends React.Component{
	render() {
		return (
			<tr>
				<td>{this.props.person.name}</td>
				<td>{this.props.person.rawScore}</td>
			</tr>
		)
	}
}


ReactDOM.render(
	<App />,
	document.getElementById('react')
)
