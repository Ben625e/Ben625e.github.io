const mongoose = require('mongoose');
const User = require('../models/user');
const passport = require('passport');

const register = async(req, res) => {
    // Validate message to insure that all parameters are present
    if (!req.body.name || !req.body.email || !req.body.password) {
        return res
            .status(400)
            .json({"message": "All fields required"});
    }

    const user = new User(
        {
            name: req.body.name,        // Set User name
            email: req.body.email,      // Set e-mail address
            password: ''                // Start with empty password
        });
    user.setPassword(req.body.password) // Set user password
    const q = await user.save();

    if(!q)
    {
        // Database returned no data
        return res
            .status(400)
            .json(err);
    } else {
        // Return new user token
        const token = user.generateJWT();
        return res
            .status(200)
            .json(token);
    }
};

const login = (req, res) => {
    // Validate message to ensure that email and password are present.
    if (!req.body.email || !req.body.password) {
        return res
            .status(400)
            .json({"message": "All fields required"});
    }

    // Delegate authentication to passport module
    passport.authenticate('local', (err, user, info) => {
        if (err) {
            // Error in Authentication Process
            return res
                .status(404)
                .json(err);
        }

        if (user) { // Auth succeeded - generate JWT and return to caller
            const token = user.generateJWT();
            res
                .status(200)
                .json({token});
        } else { // Auth failed return error
            res
                .status(401)
                .json(info);
        }
    }) (req, res);
};

// ENHANCEMENT 3 DONE 11/26/25
// DELETE: /deleteUser - Deletes a single User
// Regardless of outcome, response must include HTML status code
// and Json message to the requesting client
const deleteUser = async(req, res) => {
    // Validate the email is present
    if (!req.body.email) {
        return res
            .status(400)
            .json({"message": "Missing email field"});
    }

    const qUser = await User.findOneAndDelete(
        { 'email' : req.body.email},
    )
    .exec();

    if(!qUser)
    { // User was not found
        return res
            .status(404)
            .json(err);
    } else { // User was found and deleted
        return res
            .status(200)
            .json(qUser);
    }
}


module.exports = {
    register,
    login,
    deleteUser
};